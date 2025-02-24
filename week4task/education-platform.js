// Course and Instructor Data
const courseData = [
  {
    id: 1,
    title: "Web Development Fundamentals",
    category: "programming",
    instructor: "Adrian Calvin",
    price: 49.99,
    rating: 4.5,
    students: 1234,
    image: "webFun.png",
    description:
      "Learn the basics of web development with HTML, CSS, and JavaScript",
    level: "Beginner",
    duration: "8 weeks",
    prerequisites: ["Basic computer knowledge"],
  },
  {
    id: 2,
    title: "UX Design Masterclass",
    category: "design",
    instructor: "Ahmed Sherif",
    price: 59.99,
    rating: 4.7,
    students: 856,
    image: "uxdesign.jpg",
    description: "Master the principles of User Experience Design",
    level: "Intermediate",
    duration: "10 weeks",
    prerequisites: ["Basic design knowledge"],
  },
];

const instructorData = [
  {
    id: 1,
    name: "Adrian Calvin",
    expertise: ["Web Development", "JavaScript", "React"],
    rating: 4.8,
    students: 5000,
    image: "Adrian.jpeg",
    bio: "Expert web developer with 10 years of teaching experience",
    courses: [1, 3, 5],
  },
  {
    id: 2,
    name: "Ahmed Sherif",
    expertise: ["UX Design", "UI Design", "Figma"],
    rating: 4.9,
    students: 3500,
    image: "sherif.jpeg",
    bio: "Senior UX Designer with experience at top tech companies",
    courses: [2, 4, 6],
  },
];

// Main Class for Education Platform
class EducationPlatform {
  constructor() {
    this.initializeElements();
    this.bindEvents();
    this.loadInitialContent();
  }

  initializeElements() {
    // DOM Elements
    this.coursesContainer = document.getElementById("coursesContainer");
    this.instructorsContainer = document.getElementById("instructorsContainer");
    this.searchInput = document.getElementById("courseSearch");
    this.categoryButtons = document.querySelectorAll(".category-btn");
    this.enrollmentForm = document.getElementById("enrollmentForm");
  }

  bindEvents() {
    // Event Listeners
    if (this.searchInput) {
      this.searchInput.addEventListener(
        "input",
        this.debounce((e) => {
          this.handleSearch(e.target.value);
        }, 300)
      );
    }

    this.categoryButtons.forEach((button) => {
      button.addEventListener("click", () => {
        this.handleCategoryFilter(button.dataset.category);
        this.updateActiveCategory(button);
      });
    });

    if (this.enrollmentForm) {
      this.enrollmentForm.addEventListener("submit", (e) =>
        this.handleEnrollment(e)
      );
    }

    // Add scroll animation
    window.addEventListener("scroll", () => this.handleScrollAnimation());
  }

  loadInitialContent() {
    this.displayCourses(courseData);
    this.displayInstructors(instructorData);
    this.initializeAnimations();
  }

  displayCourses(courses) {
    if (!this.coursesContainer) return;

    this.coursesContainer.innerHTML = courses
      .map(
        (course) => `
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="course-card">
                    <div class="course-image-wrapper">
                        <img src="${course.image}" class="course-image" alt="${course.title}">
                        <div class="course-overlay">
                            <span class="course-level">${course.level}</span>
                            <span class="course-duration">${course.duration}</span>
                        </div>
                    </div>
                    <div class="course-content">
                        <h3 class="course-title">${course.title}</h3>
                        <p class="course-instructor">By ${course.instructor}</p>
                        <div class="course-meta">
                            <span class="rating">
                                <i class="fas fa-star"></i> ${course.rating}
                            </span>
                            <span class="students">
                                <i class="fas fa-users"></i> ${course.students} students
                            </span>
                        </div>
                        <p class="course-description">${course.description}</p>
                        <div class="course-footer">
                            <span class="price">$${course.price}</span>
                            <button class="btn btn-primary enroll-btn" 
                                onclick="educationPlatform.openEnrollmentModal(${course.id})">
                                Enroll Now
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        `
      )
      .join("");
  }

  displayInstructors(instructors) {
    if (!this.instructorsContainer) return;

    this.instructorsContainer.innerHTML = instructors
      .map(
        (instructor) => `
            <div class="col-lg-3 col-md-6 mb-4">
                <div class="instructor-card">
                    <img src="${
                      instructor.image
                    }" class="instructor-image" alt="${instructor.name}">
                    <h3 class="instructor-name">${instructor.name}</h3>
                    <p class="instructor-expertise">${instructor.expertise.join(
                      ", "
                    )}</p>
                    <div class="instructor-meta">
                        <span class="rating">
                            <i class="fas fa-star"></i> ${instructor.rating}
                        </span>
                        <span class="students">
                            <i class="fas fa-users"></i> ${instructor.students}
                        </span>
                    </div>
                    <p class="instructor-bio">${instructor.bio}</p>
                    <button class="btn btn-outline-primary" 
                        onclick="educationPlatform.showInstructorDetails(${
                          instructor.id
                        })">
                        View Profile
                    </button>
                </div>
            </div>
        `
      )
      .join("");
  }

  handleSearch(searchTerm) {
    searchTerm = searchTerm.toLowerCase();
    const filteredCourses = courseData.filter(
      (course) =>
        course.title.toLowerCase().includes(searchTerm) ||
        course.description.toLowerCase().includes(searchTerm) ||
        course.instructor.toLowerCase().includes(searchTerm)
    );
    this.displayCourses(filteredCourses);
  }

  handleCategoryFilter(category) {
    const filteredCourses =
      category === "all"
        ? courseData
        : courseData.filter((course) => course.category === category);
    this.displayCourses(filteredCourses);
  }

  updateActiveCategory(selectedButton) {
    this.categoryButtons.forEach((button) => button.classList.remove("active"));
    selectedButton.classList.add("active");
  }

  async handleEnrollment(event) {
    event.preventDefault();
    const formData = new FormData(event.target);
    const enrollmentData = {
      courseId: formData.get("courseId"),
      firstName: formData.get("firstName"),
      lastName: formData.get("lastName"),
      email: formData.get("email"),
      phone: formData.get("phone"),
    };

    if (this.validateEnrollmentData(enrollmentData)) {
      try {
        await this.submitEnrollment(enrollmentData);
        this.showSuccessMessage("Enrollment successful!");
        event.target.reset();
      } catch (error) {
        this.showErrorMessage("Enrollment failed. Please try again.");
      }
    }
  }

  validateEnrollmentData(data) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phoneRegex = /^\+?[\d\s-]{10,}$/;

    if (!data.firstName || !data.lastName || !data.email) {
      this.showErrorMessage("Please fill in all required fields.");
      return false;
    }

    if (!emailRegex.test(data.email)) {
      this.showErrorMessage("Please enter a valid email address.");
      return false;
    }

    if (data.phone && !phoneRegex.test(data.phone)) {
      this.showErrorMessage("Please enter a valid phone number.");
      return false;
    }

    return true;
  }

  async submitEnrollment(data) {
    // Simulated API call
    return new Promise((resolve) => {
      setTimeout(() => {
        console.log("Enrollment submitted:", data);
        resolve({ success: true });
      }, 1000);
    });
  }

  showSuccessMessage(message) {
    const alertDiv = document.createElement("div");
    alertDiv.className = "alert alert-success alert-dismissible fade show";
    alertDiv.innerHTML = `
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        `;
    document.body.insertBefore(alertDiv, document.body.firstChild);
  }

  showErrorMessage(message) {
    const alertDiv = document.createElement("div");
    alertDiv.className = "alert alert-danger alert-dismissible fade show";
    alertDiv.innerHTML = `
            ${message}
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        `;
    document.body.insertBefore(alertDiv, document.body.firstChild);
  }

  debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
      const later = () => {
        clearTimeout(timeout);
        func(...args);
      };
      clearTimeout(timeout);
      timeout = setTimeout(later, wait);
    };
  }

  handleScrollAnimation() {
    const elements = document.querySelectorAll(".animate-on-scroll");
    elements.forEach((element) => {
      const elementTop = element.getBoundingClientRect().top;
      const elementBottom = element.getBoundingClientRect().bottom;
      const isVisible = elementTop < window.innerHeight && elementBottom >= 0;

      if (isVisible) {
        element.classList.add("animated");
      }
    });
  }

  initializeAnimations() {
    // Add animation classes to elements
    const elements = document.querySelectorAll(
      ".course-card, .instructor-card"
    );
    elements.forEach((element) => {
      element.classList.add("animate-on-scroll");
    });
    this.handleScrollAnimation();
  }

  openEnrollmentModal(courseId) {
    const course = courseData.find((c) => c.id === courseId);
    if (!course) return;

    const modalHtml = `
            <div class="modal fade" id="enrollmentModal" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Enroll in ${course.title}</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form id="enrollmentForm">
                                <input type="hidden" name="courseId" value="${course.id}">
                                <div class="mb-3">
                                    <label class="form-label">First Name</label>
                                    <input type="text" class="form-control" name="firstName" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Last Name</label>
                                    <input type="text" class="form-control" name="lastName" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <input type="email" class="form-control" name="email" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Phone (optional)</label>
                                    <input type="tel" class="form-control" name="phone">
                                </div>
                                <button type="submit" class="btn btn-primary">Enroll Now</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        `;

    document.body.insertAdjacentHTML("beforeend", modalHtml);
    const modal = new bootstrap.Modal(
      document.getElementById("enrollmentModal")
    );
    modal.show();

    const form = document.getElementById("enrollmentForm");
    form.addEventListener("submit", (e) => this.handleEnrollment(e));
  }
}

// Initialize the platform
const educationPlatform = new EducationPlatform();
