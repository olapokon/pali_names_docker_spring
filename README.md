## live: http://167.71.3.20/

A Java/Spring program that scrapes the contents of http://www.palikanon.com/english/pali_names/dic_idx.html into a database, a Spring backend that allows searching the database and provides links to the original website, and a React/Next.js frontend server with autocomplete, combined with NGINX and Docker.

To run in development:

- in the scraper directory, run "./mvnw install", which will create the database in api/db/
- in the api directory, run "./mvnw package"
- in the root directory, run "docker-compose up --build"

The server is listening on http://localhost:5000/
