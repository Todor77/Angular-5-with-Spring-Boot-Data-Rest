<#import "spring.ftl" as spring>

<#-- @ftlvariable name="errors" type="org.springframework.validation.Errors" -->

<html>
    <head>
        <title>
            Customer Fields
        </title>
    </head>

    <body>

    Fill the Fields of the Customer
    <br>

  <form action = "/customer" >

    <label>Name</label><@spring.formInput "customer.firstName" />
      <span><#if errors?? && errors.hasFieldErrors('firstName')>${errors.getFieldError('firstName')}</#if></span>
    <br>
      <label>Last Name</label><@spring.formInput "customer.lastName" />
      <span><#if errors?? && errors.hasFieldErrors('lastName')>${errors.getFieldError('lastName')}</#if></span>
     <br>
      <label>Address</label><@spring.formInput "customer.address.address" />
      <span><#if errors?? && errors.hasFieldErrors('address.address')>${errors.getFieldError('address.address')}</#if></span>
    <br>
    <button>Submit</button>

  </form>

    <#if customer?? && !errors?has_content>
	    Hello ${customer.firstName!""}   ${customer.lastName!""}  ${(customer.address.address)!""}!
    <#elseif  errors?has_content>
        ${errors}
    </#if>

    <#--<#list errors as error>-->
        <#--<br>${error}-->
    <#--</#list>-->
    </body>

</html>