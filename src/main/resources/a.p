server.port=8080

logging.level.org.springframework.data.r2dbc=DEBUG

spring.r2dbc.url=r2dbc:postgresql://localhost:5432/rapid_crm
spring.r2dbc.pool.enabled=true
spring.r2dbc.pool.initial-size=5
spring.r2dbc.pool.max-size=10
spring.r2dbc.username=postgres
spring.r2dbc.password=root
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

#spring.flyway.url=jdbc:postgresql://localhost:5432/rapid_crm
#spring.flyway.user=postgres
#spring.flyway.password=root