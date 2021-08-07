URL for UI:

###http://localhost:8085/graphiql


## ***Query***

#### find All

``` graphql
#Request
 
{
  findAll {
    title
    id
    author
    genre
    height
    publisher
  }
}

#Response

{
  "data": {
    "findAll": [
      {
        "title": "Fundamentals of Wavelets",
        "id": 1,
        "author": "Goswami, Jaideva",
        "genre": "signal_processing",
        "height": 228,
        "publisher": "Wiley"
      },
      {
        "title": "Data Smart",
        "id": 2,
        "author": "Foreman, John",
        "genre": "data_science",
        "height": 235,
        "publisher": "Wiley"
      }
}
```

#### Find By title OR Id

``` graphql
#Request 
{
  findByTitle(title: "Fundamentals of Wavelets") {
    title
    id
    author
    genre
  }
}

#Response

{
  "data": {
    "findByTitle": [
      {
        "title": "Fundamentals of Wavelets",
        "id": 1,
        "author": "Goswami, Jaideva",
        "genre": "signal_processing"
      }
    ]
  }
}
```

``` graphql
#Request 
{
  findById(id: 1) {
    title
    author
  }
}

#Response

{
  "data": {
    "findById": {
      "title": "Fundamentals of Wavelets",
      "author": "Goswami, Jaideva"
    }
  }
}
```

#### Delete by Id

``` graphql
#Request 

{
  deleteById(id: 1)
}

#Response

{
  "data": {
    "deleteById": "1"
  }
}
```

## Mutation
#### Save
``` graphql

#Request

mutation {
  save(request: {title: "Praveen", id: 12312323, author: "SOni", height: 231, publisher: "Soni Corp"})
}

#Response
{
  "data": {
    "save": null
  }
}

```

#### Update
```graphql
#Request

mutation {
  update(request: {title: "Praveen", id: 12312323, author: "SOni", height: 231, publisher: "Soni Corp"}) {
    id
    title
    author
  }
}

#Response

{
  "data": {
    "update": {
      "id": 12312323,
      "title": "Praveen",
      "author": "SOni"
    }
  }
}
```

#### Find by Title and Author

```graphql

#Request
{
    findByTitleAndAuthor(request: {title: "Fundamentals of Wavelets", author: "Goswami, Jaideva"}) {
        title
        author
        id
        publisher
        height
    }
}

#Response
{
"data": {
"findByTitleAndAuthor": [
            {
            "title": "Fundamentals of Wavelets",
            "author": "Goswami, Jaideva",
            "id": 1,
            "publisher": "Wiley",
            "height": 228
            }
        ]
    }
}

```


## Errors Handling

```graphql
#Request

{
  findById(id: 2662) {
    title
    author
  }
}

#Response

{
"errors": [
     {
        "message": "No Data found for id 2662 ",
        "extensions": {
        "Error": "Invalid Request",
        "classification": "DataFetchingException"
        }
       }
    ],
    "data": {
        "findById": null
    }
}
```
