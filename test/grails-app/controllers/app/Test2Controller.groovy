package app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Test2Controller {

    Test2Service test2Service

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond test2Service.list(params), model:[test2Count: test2Service.count()]
    }

    def show(Long id) {
        respond test2Service.get(id)
    }

    def create() {
        respond new Test2(params)
    }

    def save(Test2 test2) {
        if (test2 == null) {
            notFound()
            return
        }

        try {
            test2Service.save(test2)
        } catch (ValidationException e) {
            respond test2.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'test2.label', default: 'Test2'), test2.id])
                redirect test2
            }
            '*' { respond test2, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond test2Service.get(id)
    }

    def update(Test2 test2) {
        if (test2 == null) {
            notFound()
            return
        }

        try {
            test2Service.save(test2)
        } catch (ValidationException e) {
            respond test2.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'test2.label', default: 'Test2'), test2.id])
                redirect test2
            }
            '*'{ respond test2, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        test2Service.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'test2.label', default: 'Test2'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'test2.label', default: 'Test2'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
