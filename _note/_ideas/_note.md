#### Kotlin note

1. val vs var

```kotlin
val dogName = "guri"     // immutable, like a constant
var currentWeight = 25   // mutable, can be reassigned
currentWeight -= 1       // okay!
```

2. fun vs class
```kotlin
fun sayHello(name: String): String {
	return "Hello, $name"
}
// function: does something

class Dog(val name: String) {
	fun bark() = "Woof!"
}
// class: holds data + behavior
```

3. data class

```kotlin
data class Car(val name: String, val position: Int)

val car1 = Car("pobi", 0)
val car2 = car1.copy(position = 1)
// data class: equals(), toString(), copy()
```

4. if vs when
```kotlin
val score = 85

if (score >= 90) {
    println("A")
} else if (score >= 80) {
    println("B")
}
// if: condition (true/false)

when (score) {
    in 90..100 -> println("A")
    in 80..89 -> println("B")
    else -> println("C")
}
// when: match with value
```