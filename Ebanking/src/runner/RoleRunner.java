package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\SeleniumMarchOnline\\Ebanking\\src\\Feature\\Role.feature",
                  glue="stedefination",monochrome=true,
                  plugin={"pretty","json:Target/Role/Res_Role.json"})
public class RoleRunner 
{

}
