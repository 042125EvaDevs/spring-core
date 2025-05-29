# Docker Database Setup

We will be using [Docker](https://www.docker.com/products/docker-desktop/)
containers to create our database and management tools.

## 1. Install Docker

[Docker Desktop](https://www.docker.com/products/docker-desktop/)

## 2. Create `.env`

- Used to store sensitive values

```
# .env
DATABASE_PORT="5432"
DATABASE_HOST="localhost"
DATABASE_USER="default"
DATABASE_PASSWORD="password"
DATABASE_NAME="practical-java"
```

## 3. Create `docker-compose.yaml`

### PostgreSQL

_docker-compose.yml_ contents:

```yaml
services:
  postgres:
    image: postgres
    environment:
      POSTGRES_USER: ${DATABASE_USER}
      POSTGRES_PASSWORD: ${DATABASE_PASSWORD}
      POSTGRES_DB: ${DATABASE_NAME}
      PGDATA: /data/postgres
    volumes:
      - postgres:/data/postgres
    ports:
      - '5432:5432'
    networks:
      - postgres
    restart: unless-stopped

  pgadmin:
    image: dpage/pgadmin4
    environment:
      PGADMIN_DEFAULT_EMAIL: ${PGADMIN_DEFAULT_EMAIL:-pgadmin4@pgadmin.org}
      PGADMIN_DEFAULT_PASSWORD: ${PGADMIN_DEFAULT_PASSWORD:-admin}
      PGADMIN_CONFIG_SERVER_MODE: 'False'
    volumes:
      - pgadmin:/var/lib/pgadmin
    ports:
      - '5050:80'
    networks:
      - postgres
    restart: unless-stopped

networks:
  postgres:
    driver: bridge
volumes:
  postgres:
  pgadmin:
```

### MySQL

_docker-compose.yml_ contents:

```yaml
services:
  mysql:
    image: mysql:latest
    ports:
      - "3306:3306"
    environment:
      MYSQL_ROOT_PASSWORD: ${DATABASE_PASSWORD}
      MYSQL_HOST: ${DATABASE_HOST}
      MYSQL_USER: ${DATABASE_USER}
      MYSQL_PASSWORD: ${DATABASE_PASSWORD}
      MYSQL_DATABASE: ${DATABASE_NAME}
    volumes:
      - mysql:/var/lib/mysql
    restart: unless-stopped
networks:
  mysql:
    driver: bridge
volumes:
  mysql:
  workbench:
```

## Start services

```bash
docker compose up -d
```
## Stopping services

```bash
docker compose down -v
```

