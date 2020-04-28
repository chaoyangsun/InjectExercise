# InjectExercise功能：

使用注解实现findviewbyid功能（FindView注解），并实现解析Intent的参数（Autowired注解）

# 使用示例：

        //使用Autowired注解 自动解析Intent参数
        @Autowired
        public String name;
        @Autowired("boy")
        public boolean isBoy;
        @Autowired("age")
        public int age;
        @Autowired
        private Double money;
        //使用FindView注解 自动使用findviewbyid初始化
        @FindView(R.id.text1)
        TextView textView;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second);
            AutowiredUtils2.inject(this);
            FindViewUtil.injectView(this);
            textView.setText(name + " - " + isBoy + " - " + age + " - " + money);
        }


