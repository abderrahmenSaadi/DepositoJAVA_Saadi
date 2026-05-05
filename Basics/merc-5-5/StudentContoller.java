

public class StudentContoller {
    private Student model;
    private StudentView view;
    public StudentContoller(Student model, StudentView view){
        this.model = model;
        this.view = view;
    }
    public void setNameStudent(String name){
        model.setName(name);
    }
    public void setVotoStudent(String voto){
        model.setVoto(voto);
    }
public void applyChanges(){
    view.printStudentDetails(model.getName(), model.getVoto());
    }
    public static void main(String[] args) {
        Student model = new Student("Saadi", "30");
        StudentView view = new StudentView();
        StudentContoller controller = new StudentContoller(model, view);
        controller.applyChanges();
    }
}
    