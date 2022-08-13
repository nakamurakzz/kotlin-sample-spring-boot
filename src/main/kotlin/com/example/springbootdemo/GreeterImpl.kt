package com.example.springbootdemo

import org.springframework.stereotype.Component

// Component アノテーションを定義するとDI対象のクラスになる
@Component
class GreeterImpl: Greeter {
    override fun sayHello(name:String):String {
        return "Hello $name"
    }
}