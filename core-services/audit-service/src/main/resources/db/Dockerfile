# Use an ARM64-compatible Flyway image
FROM flyway/flyway:10.7

COPY ./migration/main /flyway/sql
COPY migrate.sh /usr/bin/migrate.sh

RUN chmod +x /usr/bin/migrate.sh

ENTRYPOINT ["/usr/bin/migrate.sh"]