class Student {
 private String name;
 private String voto;
 public Student(String name, String voto){
    this.name = name;
    this.voto = voto;
 }
public String getName(){
    return this.name;
}
public String getVoto(){
    return this.voto;
}
public void setName(String name){
    this.name = name;   
}
public void setVoto(String voto){
    this.voto = voto;   
}

}