package ma.dnaengineering.backend;
import java.io.IOException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.dnaengineering.backend.EmployeeService.EmployeeData;


@RestController
@RequestMapping("/employees") // Define the base path for employee-related APIs
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/process-csv")
    public ResponseEntity<EmployeeData> processCSVFile()  {
        try{
        EmployeeData employeeData = employeeService.processCSVFile("C:\\Users\\houssam\\Desktop\\Full-Stack-Internship-Home-Assignment\\data\\employees.csv"); 
        return new ResponseEntity<>(employeeData, HttpStatus.OK);}
        catch(IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
