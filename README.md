# Reto
El puerto por el que se expone la app es: 8090

Curl para consultar un usuario
``` 
curl --location --request GET 'http://localhost:8090/user/23445322'
```
Curl para agregar
``` 
curl --location --request POST 'http://localhost:8090/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "documentNumber":"12312",
    "documentType":"C"
}'
```
