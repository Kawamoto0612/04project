package student.Student.management;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	private final Map<String, String> studentData = new HashMap<>();

	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
	}

	@GetMapping("/students")
	public Map<String, String> getAllStudents(){
		return studentData;
	}

	@PostMapping("/addStudent")
	public String addStudent(@RequestParam String name, @RequestParam String age){
		studentData.put(name,age);
	 return name +"さんを追加しました（年齢："+ age +"歳）";
}

 @PostMapping("/updateStudent")
	public  String updateStudent(@RequestParam String name,@RequestParam String age) {
		if (studentData.containsKey(name)){
			studentData.put(name,age);
			return name + "さんの年齢を" + age + "歳に更新しました";
		} else 	{
			return name + "さんは存在しません";
		}
 }
}
