package com.zcq.house.vo;

/**
 * Created by changqingzhou on 2017/8/1.
 */
public class TestVo1 {
    private String id;

    private TestVo2 testVo2;

    private TestVo3 testVo3;

    public TestVo2 getTestVo2() {
        return testVo2;
    }

    public void setTestVo2(TestVo2 testVo2) {
        this.testVo2 = testVo2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TestVo3 getTestVo3() {
        return testVo3;
    }

    public void setTestVo3(TestVo3 testVo3) {
        this.testVo3 = testVo3;
    }


    public static final class TestVo1Builder {
        private String id;
        private TestVo2 testVo2;
        private TestVo3 testVo3;

        private TestVo1Builder() {
        }

        public static TestVo1Builder aTestVo1() {
            return new TestVo1Builder();
        }

        public TestVo1Builder withId(String id) {
            this.id = id;
            return this;
        }

        public TestVo1Builder withTestVo2(TestVo2 testVo2) {
            this.testVo2 = testVo2;
            return this;
        }

        public TestVo1Builder withTestVo3(TestVo3 testVo3) {
            this.testVo3 = testVo3;
            return this;
        }

        public TestVo1 build() {
            TestVo1 testVo1 = new TestVo1();
            testVo1.setId(id);
            testVo1.setTestVo2(testVo2);
            testVo1.setTestVo3(testVo3);
            return testVo1;
        }
    }
}
