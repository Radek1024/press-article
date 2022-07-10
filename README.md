# press-article

REST API for press articles.\
The press article object is in the below JSON form:

    {
        "content":{"title":"Healthy programmer",
                  "contentBody":"To lead a healthy lifie You need to get up more often..."},
        "publicationDate":"2022-07-02",
        "magazineName":"Green programmer",
        "author":{"name":"Oliver",
                 "lastName":"Twisted"}
    }


The API has typical CRUD endpionts:\
`localhost:8080/api/upload` endpoint for adding an article

`localhost:8080/api/pressArticles` endpoint for retrieving a list of all articles

`localhost:8080/api/pressArticle/{id}` endpoint for retrieving an article with a given id

`localhost:8080/api/pressArticles/body?query=` endpoint for retrieving a list of articles containing a specified query in the content body

`localhost:8080/api/pressArticles/title?query=` endpoint for retrieving a list of articles containing a specified query in the content title

`localhost:8080/api/pressArticle/remove/{id}` endpoint for removal of a article with a given id

`localhost:8080/api/pressArticle/{id}` endpoint for updating an article by given id
