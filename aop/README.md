# SpringBoot - Aspect Oriented Programming

Este es un proyecto simple para mostrar qué es y cómo se utiliza AOP.

## Endpoints

#### Users Endpoints

<details>
 <summary><code>GET</code> <code><b>http://localhost:8091/users</b></code> <code>Todos los usuarios</code></summary>

##### Parameters

> None

##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `application/json;charset=UTF-8`        | json string                                                         |

</details>

<details>
 <summary><code>GET</code> <code><b>http://localhost:8091/users/{id}</b></code> <code>Recuperar usuarios por Id</code></summary>

##### Parameters

> | name              |  type     | data type      | description                         |
> |-------------------|-----------|----------------|-------------------------------------|
> | `id` |  required | int   | El identificador del usuario    |

##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `application/json;charset=UTF-8`        | json string                                                         |
> | `500`         | `text/html;charset=utf-8`         | None
</details>

<details>
 <summary><code>GET</code> <code><b>http://localhost:8091/users/search/{username}</b></code> <code>Recuperar usuarios por userName</code></summary>

##### Parameters

> | name              |  type     | data type      | description                         |
> |-------------------|-----------|----------------|-------------------------------------|
> | `username` |  required | string   | El nombre del usuario    |

##### Responses

> | http code     | content-type                      | response                                                            |
> |---------------|-----------------------------------|---------------------------------------------------------------------|
> | `200`         | `application/json;charset=UTF-8`        | json string                                                         |
> | `500`         | `text/html;charset=utf-8`         | None                                                                |
</details>

## Conceptos 

- **Aspect** (Qué): La lógica que queremos inyectar en nuestro código productivo.
- **Advice** (Cuándo): ¿Cuándo queremos que la lógica definida en el aspecto corra? En general es **Before** o **After** la ejecución de un método. *Afterthrowing* una excepción específica. O **Around**, antes y después de la ejecución de un método.
- **Pointcut** (Dónde): ¿En que parte del código productivo queremos que se inyecte la lógica definida en el aspecto?

## Importante

- Spring AOP **no** funciona para objetos no manejados por el contexto. 
- Explicado en https://docs.spring.io/spring-framework/docs/2.5.5/reference/aop.html, seccion 6.4.1 Spring AOP o Full AspectJ. "If you need to advise objects not managed by the Spring container (such as domain objects typically), then you will need to use AspectJ". 