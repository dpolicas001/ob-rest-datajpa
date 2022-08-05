package com.example.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Solo sirve de ejemplo pero queremos usar JSON asi que ver la clase BookController
@RestController
public class HelloController {

    //Para comunicarlo con internet, poniendo /hola en la barra de direcciones accedo
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo";
    }


    @GetMapping("/bootstrap")
    public String bootStrap(){

        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Hola Mundo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
                  </head>
                  <body>
                    <h1>Hola mundo desde Spring Boot!</h1>
                        <a class="btn btn-primary" href="https://www.google.com"> Google </a>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
                  </body>
                </html>
                                
                                
                """;
    }


}
