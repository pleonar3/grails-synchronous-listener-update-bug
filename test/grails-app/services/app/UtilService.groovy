package app

class UtilService {
    def test2Service

    def calculate(test) {
        println 'do I exist?'

        if (!test.test2) {
            test.test2 = new Test2()
        }

        test.test2.z = test.x * test.y
        test2Service.save(test.test2)
    }
}
