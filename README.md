# URL Shortener

[![CircleCI](https://circleci.com/gh/rahulpopuri/url-shortener/tree/master.svg?style=svg)](https://circleci.com/gh/rahulpopuri/url-shortener/tree/master)

A simple Spring Boot based URL Shortener

Hosted on heroku: https://spring-boot-url-shortener.herokuapp.com

## Getting Started

1. Set up a new dyno on Heroku and add the ClearDB add-on: https://devcenter.heroku.com/articles/cleardb

2. Once it's all set up, go to the Settings page for your dyno and click on 'Reveal Config vars'.
You should find CLEARDB_DATABASE_URL containing the host, user, password and table name

3. Set the following environment variables on your machine:
```
MYSQL_HOST
MYSQL_PORT (mysql default is 3306)
MYSQL_USERNAME
MYSQL_PASSWORD
MYSQL_TABLE_NAME
```

## Usage
- Send a POST request with the url to shorten:
```
curl -d "http://www.google.com" -X POST http://spring-boot-url-shortener.herokuapp.com/url
```
which will return the shortened url to you

- Send a GET request with the 'short' url:
```
curl -X GET http://spring-boot-url-shortener.herokuapp.com/url/{shorturl}
```
which should return http://www.google.com

## How It Works

### Shorten
1. Save URL in database - retrieve row ID from DB
2. Encode row ID to a short string and return to client

### Retrieve
1. Decode the short URL to an integer
2. Lookup integer in the DB and return corresponding URL

## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Gradle](https://gradle.org)
* [Heroku](https://www.heroku.com)
* [ClearDB](https://elements.heroku.com/addons/cleardb) - A free MySQL DB add-on for Heroku
* [CircleCI](https://circleci.com)

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT)

## Acknowledgments

* The code for URL encode/decode is from https://github.com/delight-im/ShortURL/tree/master/Java
