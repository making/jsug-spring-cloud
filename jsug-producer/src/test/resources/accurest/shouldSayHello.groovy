io.codearte.accurest.dsl.GroovyDsl.make {
    request {
        method 'GET'
        urlPath '/'
    }
    response {
        status 200
        body('Hello @11111111-1111-1111-1111-111111111111')
        headers {
            header('Content-Type': 'text/plain;charset=ISO-8859-1')
        }
    }
}