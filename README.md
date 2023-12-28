# SpringBoot E-commerce 

_Prueba técnica de realización de la parte backend de una aplicación e-commerce con SpringBoot hecha como una API REST. El carrito tiene un tiempo de vida de 10 minutos_

## 1) GET http://localhost:8080/api/carts/1

Respuesta

{
    "id": 1, 
    "description": "Producto 1", 
    "amount": 2
}

## 2) POST http://localhost:8080/api/carts/1/products

Body JSON

{
    "id": 1, 
    "description": "Producto 1", 
    "amount": 2
}


Respuesta

{
    "id": 1,
    "products": [
        {
            "id": 1,
            "description": "Producto 1",
            "amount": 2
        }
    ],
    "ttl": 1703780467639
}


## 3) DELETE http://localhost:8080/api/carts/1


## Autor

* **Montse Cutillas ** - (https://github.com/co-mon)


