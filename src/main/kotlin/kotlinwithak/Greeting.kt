package kotlinwithak
import java.util.concurrent.atomic.AtomicLong
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
data class Greeting(val id: Long, val content: String)

@RestController
class GreetingController {
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "world") name: String): Greeting {
        return Greeting(counter.incrementAndGet(), "hello, $name")
    }
}
