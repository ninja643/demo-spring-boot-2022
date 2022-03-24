package rs.ac.ni.pmf.web.demospringboot2022.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Greeting
{
	long id;
	String content;
}
