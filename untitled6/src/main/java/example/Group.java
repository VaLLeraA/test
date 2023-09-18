package example;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private int id;
    @Column(name = "group_name")
    private String groupName;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "group")
    private List <Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addStudentToGroup(Student student){
        if(students == null){
            students = new ArrayList<>();
            students.add(student);
            student.setGroup(this);
        } else {
            students.add(student);
            student.setGroup(this);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String nameOfGroup) {
        this.groupName = nameOfGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("group_id=").append(id);
        sb.append(", groupName='").append(groupName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
