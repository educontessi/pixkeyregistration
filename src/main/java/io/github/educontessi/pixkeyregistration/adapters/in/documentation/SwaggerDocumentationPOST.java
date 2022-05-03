package io.github.educontessi.pixkeyregistration.adapters.in.documentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(description = "Save resource")
@SwaggerDocumentationGlobal
@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Resource saved successfully")})
public @interface SwaggerDocumentationPOST {

}
