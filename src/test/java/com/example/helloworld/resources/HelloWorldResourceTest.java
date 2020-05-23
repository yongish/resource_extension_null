package com.example.helloworld.resources;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.helloworld.api.Saying;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;

public class HelloWorldResourceTest {
    @ClassRule
    public static final ResourceExtension resources = ResourceExtension.builder()
            .addResource(new HelloWorldResource("",""))
            .build();

    @Test
    public void testGetPerson() {
        assertThat(resources.target("/person/blah").request().get(Saying.class))
                .isEqualTo(new Saying(1, ""));
    }
}
