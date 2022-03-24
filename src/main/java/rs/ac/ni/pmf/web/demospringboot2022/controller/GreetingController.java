package rs.ac.ni.pmf.web.demospringboot2022.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;
import rs.ac.ni.pmf.web.demospringboot2022.model.Greeting;

@RestController
public class GreetingController
{
	private static final String TEMPLATE = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();
	private final List<Greeting> _greetings = new ArrayList<>();

	@GetMapping(value = "/greetings")
	public Greeting greet(@RequestParam(value = "name", defaultValue = "World") final String nameToGreet)
	{
		final Greeting greeting = Greeting.builder()
			.id(counter.incrementAndGet())
			.content(String.format(TEMPLATE, nameToGreet))
			.build();

		_greetings.add(greeting);

		return greeting;
	}
}
