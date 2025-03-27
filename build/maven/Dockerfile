# syntax=docker/dockerfile:experimental
FROM maven:3.9.6-amazoncorretto-17 AS build
ARG WORK_DIR
WORKDIR /app

# Copy pom.xml and pre-fetch dependencies using cache mount
COPY ${WORK_DIR}/pom.xml ./pom.xml
RUN --mount=type=cache,target=/root/.m2/repository \
    mvn dependency:go-offline -B

# Copy the remaining files
COPY build/maven/start.sh ./start.sh
COPY ${WORK_DIR}/src ./src

# Build the project using the cached Maven repository
RUN --mount=type=cache,target=/root/.m2/repository \
    mvn -B -f /app/pom.xml package

# Runtime image – using a multi-arch base image
FROM amazoncorretto:17-alpine
WORKDIR /opt/egov

# Copy artifacts from the build stage
COPY --from=build /app/target/*.jar /app/start.sh /opt/egov/

# Ensure the start script has correct line endings and is executable
RUN dos2unix /opt/egov/start.sh && chmod +x /opt/egov/start.sh

# Verify architecture inside the container
RUN uname -m

CMD ["/opt/egov/start.sh"]
