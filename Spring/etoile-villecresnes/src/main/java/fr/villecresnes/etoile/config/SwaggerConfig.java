package fr.villecresnes.etoile.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  //@formatter:off
  @Bean
  public Docket api() { 
    return new Docket(DocumentationType.SWAGGER_2)  
      .select()                                  
      .apis(RequestHandlerSelectors.basePackage("fr.villecresnes.etoile.controller"))              
      .paths(PathSelectors.any())
      .build()
      .apiInfo(apiInfo())
      /*
      .tags(
          new Tag("01 - Données gaz", "APIs relatives à la conso de gaz"),
          new Tag("02 - Données météo", "APIs concernant les données d'historique de température"),          
          new Tag("03 - Gestion du password", "APIs de gestion du password"),      
          new Tag("04 - Divers", "APIs diverses (ex : envoyer un message)")
      )
      */
    ;
  }

  @Bean
  UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder()
        .defaultModelsExpandDepth(-1)
        .docExpansion(DocExpansion.LIST)
        .validatorUrl(null)
        .build();
  }  
  //@formatter:on  

  private ApiInfo apiInfo() {

    ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

    apiInfoBuilder.title("GenericAPI");
    apiInfoBuilder.version("1.0");
    apiInfoBuilder.description("API générique pour les APIs de la R&D");
    apiInfoBuilder.contact(new Contact("Tristan ROBET", "", "tristan-externe.robet@edf.fr"));

    return apiInfoBuilder.build();
  }

}
