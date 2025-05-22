class User {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.phone = builder.phone;
        this.email = builder.email;
    }

    public static class UserBuilder {
        private final String name;
        private int age;
        private String address;
        private String phone;
        private String email;

        public UserBuilder(String name) {
            this.name = name;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String toString() {
        return name + " | Age: " + age + " | Addr: " + address + " | Phone: " + phone + " | Email: " + email;
    }
}

class BuilderPatternDemo {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Vishnu").setAge(25).setPhone("9999999999").build();
        User user2 = new User.UserBuilder("Aru").setAddress("Bangalore").setEmail("aru@example.com").build();
        System.out.println(user1);
        System.out.println(user2);
    }
}