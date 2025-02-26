package dingcorithm.two_week;

public class ClassObject {

    String name;
    // 생성자

    public ClassObject(String name) {
        this.name = name;
    }

    public void showConstroctor() {
        System.out.println("안녕하세요, 저는 " + this.name + " 입니다.");
    }
}
