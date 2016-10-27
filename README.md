package funcala.example


def Int add(Int a, Int b) {a+b}
def Int add2(Int a, Int b) = a+b

def Int ok(Int a) = a + 10

class Hi{
    def say() {
        println("hi")
    }
}

class Hello {
    var Int a
    var b = 10
    def self(Int a, Int b) {
        a+b
    }

    def hello() {
        println("hello")
    }

    def say(Int a) {
        ok(a)
    }

    def Int add(Int i) {
        add(i, a+b)
    }
    def Int add(Int a, Int b) = a + b

    def Int add2(Int a, Int b) {
        return a + b
    }
}

def Int add(Int i) = new Hello(10,10).add(i)

def main() {
    var hello = new Hello(10,10)
    var a = hello.add(5)
    var b = add(5)
    println(a)
    println(b)
}

