# Advanced Java Assignments: Lambda Expressions & Functional Interfaces

## Topic
**Java Lambda Expressions and Functional Interfaces**

## Level
**Advanced / High Complexity**

## Objective
These assignments are designed to help students understand and apply:

- Lambda Expressions
- Custom Functional Interfaces
- Built-in Functional Interfaces
- Predicate
- Function
- Consumer
- Supplier
- BiFunction
- BiConsumer
- Comparator
- Stream API
- Method Chaining
- Real-time Business Use Cases

---

# Task 1: Dynamic Employee Salary Processing Engine

## Real-Time Use Case
HR systems apply different salary rules based on employee role, experience, and performance rating.

## Requirements
Create an `Employee` class with the following fields:

```java
private Integer employeeId;
private String employeeName;
private String department;
private String role;
private Integer experience;
private Double salary;
private Double performanceRating;
```

Create a custom functional interface:

```java
@FunctionalInterface
interface SalaryProcessor {
    double process(Employee employee);
}
```

Implement the following using lambda expressions:

1. Add 20% hike for employees with rating greater than or equal to 4.5
2. Add 15% hike for employees with experience greater than or equal to 5 years
3. Add 10% hike for Developers
4. Add 8% hike for Testers
5. No hike for rating below 3

## Additional Complexity
Use the following functional interfaces:

```java
Predicate<Employee>
Function<Employee, Double>
Consumer<Employee>
Comparator<Employee>
```

## Expected Output

```text
Employee: Ravi
Role: Developer
Old Salary: 60000
Hike Applied: 20%
Final Salary: 72000
```

---

# Task 2: Online Course Recommendation System

## Real-Time Use Case
E-learning platforms recommend courses based on student profile, skills, experience, and budget.

## Requirements
Create a `Student` class with the following fields:

```java
private Integer studentId;
private String studentName;
private String qualification;
private List<String> skills;
private Integer experience;
private String preferredTechnology;
private Double budget;
```

Create a `Course` class with the following fields:

```java
private Integer courseId;
private String courseName;
private String technology;
private String level;
private Double fee;
private String duration;
private Double rating;
```

## Business Rules

1. If student has Java skill, recommend Java Fullstack or Spring Boot courses
2. If student has Python skill, recommend Python Fullstack or Data Science courses
3. If budget is below 20000, recommend affordable courses only
4. If experience is 0, recommend beginner-level courses
5. If experience is greater than or equal to 3, recommend advanced courses
6. Sort recommended courses by rating in descending order

## Functional Interfaces to Use

```java
Predicate<Course>
Function<Student, List<Course>>
Comparator<Course>
Consumer<Course>
```

## Expected Output

```text
Recommended Courses for Suresh:
1. Java Fullstack - ₹25000 - Rating: 4.8
2. Spring Boot Microservices - ₹18000 - Rating: 4.7
```

---

# Task 3: Order Processing Workflow Using Lambda Chain

## Real-Time Use Case
E-commerce platforms process orders through multiple stages such as validation, discount, tax, payment, and delivery.

## Requirements
Create an `Order` class with the following fields:

```java
private String orderId;
private String customerName;
private List<String> items;
private Double totalAmount;
private String paymentStatus;
private String deliveryStatus;
private String couponCode;
```

Create a custom functional interface:

```java
@FunctionalInterface
interface OrderProcessor {
    Order process(Order order);

    default OrderProcessor andThen(OrderProcessor nextProcessor) {
        return order -> nextProcessor.process(this.process(order));
    }
}
```

Create lambda processors for:

1. Validate order
2. Apply coupon discount
3. Calculate GST
4. Confirm payment
5. Assign delivery partner
6. Update delivery status

## Additional Complexity
Chain multiple lambda processors:

```java
Order finalOrder = validateOrder
        .andThen(applyCoupon)
        .andThen(calculateGst)
        .andThen(confirmPayment)
        .andThen(assignDeliveryPartner)
        .andThen(updateDeliveryStatus)
        .process(order);
```

## Expected Output

```text
Order ID: ORD101
Original Amount: 5000
Coupon Applied: GENAI10
GST Added: 18%
Final Amount: 5310
Payment Status: SUCCESS
Delivery Status: ASSIGNED
```

---

# Task 4: Loan Eligibility Rule Engine

## Real-Time Use Case
Banks use multiple validation rules to approve or reject loan applications.

## Requirements
Create a `Customer` class with the following fields:

```java
private Integer customerId;
private String customerName;
private Integer age;
private Double monthlySalary;
private Integer creditScore;
private Double existingEmi;
private String employmentType;
private Double requestedLoanAmount;
```

Create a custom functional interface:

```java
@FunctionalInterface
interface LoanRule {
    boolean validate(Customer customer);

    default LoanRule and(LoanRule other) {
        return customer -> this.validate(customer) && other.validate(customer);
    }

    default LoanRule or(LoanRule other) {
        return customer -> this.validate(customer) || other.validate(customer);
    }

    default LoanRule negate() {
        return customer -> !this.validate(customer);
    }
}
```

## Validation Rules

1. Age must be between 21 and 60
2. Monthly salary must be greater than or equal to 50000
3. Credit score must be greater than or equal to 750
4. Existing EMI should be less than 40% of salary
5. Requested loan amount should not exceed 20 times monthly salary
6. Employment type should be SALARIED or BUSINESS

## Additional Complexity
Generate failed rule reasons for rejected customers.

## Expected Output

```text
Customer: Mahesh
Loan Status: APPROVED
Reason: All eligibility conditions satisfied
```

Or:

```text
Customer: Kiran
Loan Status: REJECTED
Failed Rules:
- Credit score is below 750
- Existing EMI is more than allowed limit
```

---

# Task 5: Student Placement Filtering System

## Real-Time Use Case
Training institutes filter students before sharing profiles with companies.

## Requirements
Create a `Student` class with the following fields:

```java
private Integer studentId;
private String studentName;
private String courseName;
private Integer graduationYear;
private Double percentage;
private Integer backlogs;
private Double mockRating;
private List<String> skills;
private Boolean resumeAvailable;
private Boolean feePaid;
```

## Eligibility Conditions

1. Graduation year should be 2022 or later
2. Percentage should be greater than or equal to 60
3. Backlogs should be 0
4. Mock rating should be greater than or equal to 4
5. Resume should be available
6. Fee should be fully paid
7. Skills should contain Java or Python

## Functional Interfaces to Use

```java
Predicate<Student>
Consumer<Student>
Function<Student, String>
Comparator<Student>
```

## Additional Complexity
Generate a placement report containing:

1. Eligible students
2. Rejected students
3. Rejection reasons
4. Eligible students sorted by mock rating descending
5. Students grouped by course

## Expected Output

```text
Eligible Students for Placement:
1. Ravi - Java Fullstack - Rating: 4.8
2. Sneha - Python Fullstack - Rating: 4.6

Rejected Students:
Kiran - Reason: Backlogs available, Resume missing
```

---

# Task 6: Notification Routing System

## Real-Time Use Case
Applications send notifications using Email, SMS, WhatsApp, and Push Notification.

## Requirements
Create a `Notification` class with the following fields:

```java
private String notificationId;
private String userName;
private String email;
private String mobile;
private String message;
private String notificationType;
private String priority;
```

Create a custom functional interface:

```java
@FunctionalInterface
interface NotificationSender {
    void send(Notification notification);
}
```

Create lambda expressions for:

1. Email notification
2. SMS notification
3. WhatsApp notification
4. Push notification

## Additional Complexity
Use `Map<String, NotificationSender>` to dynamically route notifications.

```java
Map<String, NotificationSender> senders = new HashMap<>();
senders.put("EMAIL", emailSender);
senders.put("SMS", smsSender);
senders.put("WHATSAPP", whatsappSender);
senders.put("PUSH", pushSender);
```

## Advanced Rules

1. HIGH priority notification should be sent through Email and WhatsApp
2. NORMAL priority notification should be sent through selected channel only
3. If mobile is missing, skip SMS and WhatsApp
4. If email is missing, skip Email

## Expected Output

```text
Sending HIGH priority notification...
Email Sent to ravi@gmail.com
WhatsApp Sent to 9876543210
Message: Your class starts at 7:30 AM
```

---

# Task 7: Payment Gateway Strategy Using Functional Interface

## Real-Time Use Case
Applications support multiple payment modes like UPI, Credit Card, Net Banking, and Wallet.

## Requirements
Create a `PaymentRequest` class with the following fields:

```java
private String paymentId;
private String customerName;
private Double amount;
private String paymentMode;
private String couponCode;
private String bankName;
private String walletName;
```

Create a `PaymentResponse` class with the following fields:

```java
private String transactionId;
private String paymentStatus;
private Double finalAmount;
private String message;
```

Create a custom functional interface:

```java
@FunctionalInterface
interface PaymentGateway {
    PaymentResponse pay(PaymentRequest request);
}
```

Implement payment strategies using lambdas:

1. UPI payment
2. Credit card payment
3. Net banking payment
4. Wallet payment

## Additional Complexity
Before payment:

1. Validate amount
2. Apply coupon
3. Add gateway charges
4. Generate transaction ID
5. Return payment response

Use the following functional interfaces:

```java
Function<PaymentRequest, PaymentRequest>
Predicate<PaymentRequest>
Supplier<String>
```

## Expected Output

```text
Payment Mode: UPI
Original Amount: 25000
Coupon Applied: COURSE10
Final Amount: 22500
Transaction ID: TXN202606091001
Payment Status: SUCCESS
```

---

# Task 8: File Processing Framework Using Lambda

## Real-Time Use Case
Backend applications process CSV, JSON, XML, and TXT files differently.

## Requirements
Create a `FileData` class with the following fields:

```java
private String fileName;
private String fileType;
private Double fileSizeInMb;
private String content;
private String uploadedBy;
```

Create a custom functional interface:

```java
@FunctionalInterface
interface FileProcessor {
    void process(FileData fileData);
}
```

Create lambda expressions for:

1. CSV processing
2. JSON processing
3. XML processing
4. TXT processing

## Additional Complexity
Use `Map<String, FileProcessor>` to select processor dynamically.

## Validation Rules

1. File size should be less than 5 MB
2. File type should be allowed
3. Content should not be empty
4. Uploaded user should not be null

Use the following functional interfaces:

```java
Predicate<FileData>
Consumer<FileData>
BiConsumer<String, String>
```

## Expected Output

```text
File Name: students.csv
Validation: SUCCESS
Processor Selected: CSV Processor
CSV Records Processed Successfully
```

---

# Task 9: Interview Feedback Analyzer

## Real-Time Use Case
Placement teams analyze mock interview feedback and decide student readiness.

## Requirements
Create an `InterviewFeedback` class with the following fields:

```java
private Integer studentId;
private String studentName;
private Double technicalRating;
private Double communicationRating;
private Double codingRating;
private Double confidenceRating;
private Double problemSolvingRating;
private List<String> questionsAsked;
private List<String> strengths;
private List<String> weaknesses;
```

Use lambdas to calculate:

1. Overall rating
2. Performance status
3. Placement eligibility
4. Improvement suggestions

## Business Rules

```text
Overall Rating = Average of all ratings

Rating >= 8      : Excellent
Rating >= 6      : Good
Rating >= 4      : Average
Rating below 4   : Needs Improvement

Placement eligible if overall rating >= 6 and coding rating >= 6
```

## Functional Interfaces to Use

```java
Function<InterviewFeedback, Double>
Function<Double, String>
Predicate<InterviewFeedback>
Consumer<InterviewFeedback>
```

## Additional Complexity
Generate detailed report:

1. Group students by performance status
2. Sort students by overall rating descending
3. List non-eligible students with improvement suggestions

## Expected Output

```text
Student: Ravi
Overall Rating: 7.8
Performance: Good
Placement Eligible: Yes
Suggestions: Improve communication and system design basics
```

---

# Task 10: Dynamic Report Generator Using Lambdas

## Real-Time Use Case
Admin dashboards generate different reports dynamically based on students, courses, payments, and enrollments.

## Requirements
Create the following classes:

```java
Student
Course
Payment
Enrollment
```

Create a custom generic functional interface:

```java
@FunctionalInterface
interface ReportGenerator<T, R> {
    R generate(List<T> data);
}
```

Generate the following reports using lambdas:

1. Total revenue report
2. Course-wise enrollment report
3. Pending payment report
4. Trainer-wise course report
5. Monthly admission report
6. Top 5 high-fee courses

## Additional Complexity
Use the following concepts:

```java
Function
Predicate
Consumer
Supplier
Comparator
Collectors.groupingBy()
Collectors.summingDouble()
Collectors.counting()
Collectors.toList()
```

## Expected Output

```text
Course Wise Enrollment Report:

Java Fullstack     : 120 Students
Python Fullstack   : 80 Students
DevOps             : 65 Students
Data Science       : 50 Students

Total Revenue: ₹35,50,000
Pending Payments: ₹4,20,000
```

---

# Submission Guidelines for Students

Students should follow the below guidelines while submitting assignments:

1. Use Java 8 or above
2. Use Lambda Expressions wherever possible
3. Use custom Functional Interfaces in at least 5 tasks
4. Use built-in Functional Interfaces:
   - Predicate
   - Function
   - Consumer
   - Supplier
   - BiFunction
   - BiConsumer
5. Use Stream API for filtering, mapping, sorting, grouping, and reducing
6. Follow proper class naming and package structure
7. Add sample input data inside the main method
8. Print clear output for each task
9. Handle invalid data properly
10. Submit source code and output screenshots

---

# Evaluation Criteria

| Criteria | Marks |
|---|---:|
| Correct usage of Lambda Expressions | 20 |
| Correct usage of Functional Interfaces | 20 |
| Stream API implementation | 20 |
| Real-time business logic implementation | 15 |
| Code readability and structure | 10 |
| Exception handling and validations | 10 |
| Output screenshots | 5 |
| **Total** | **100** |

---

**Prepared By: Team Ashok IT**
