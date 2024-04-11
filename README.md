# SpartaJavaWork

This repository contains my solutions to tasks completed as part of training in Java Test Automation at Sparta Global.

## Topics covered

- Business Induction, Agile & Scrum
- ISTQB Certified Tester Foundation Level
- Test Analysis
- Java Core & OOP
- Advanced Unit Testing & SQL
- Further Java
- Automated Web Testing
- Automated API Testing & Final Quality Gate

## Notes for GitHubCommitCommentsTests class

### Dependencies

- `io.restassured`: This library provides a fluent interface for testing HTTP and RESTful APIs.
- `org.hamcrest`: This library allows for expressive and readable assertions in tests.

### Test Class: GitHubCommentTests

- **Constants**: `BASE_URI` and `BASE_PATH` define the base URI and base path for GitHub API requests.
- **Instance Variable**: `commentId` stores the ID of a comment created during setup for use in subsequent tests.

### Test Methods

1. **`setUp()`**:

   - Creates a comment on a commit identified by `commit_sha`.
   - Retrieves the ID of the created comment and stores it in `commentId`.
   - HTTP POST request to create a comment with a predefined body.

2. **`tearDown()`**:

   - Retrieves all comment IDs associated with the repository.
   - Deletes each comment individually by its ID.
   - Ensures each deletion returns a 204 No Content status.

3. **`getAllRepositoryComments_Returns1Comment()`**:

   - Tests if the endpoint to get all repository comments returns exactly one comment.

4. **`getCommentWithId_ReturnsThatComment()`**:

   - Tests if a specific comment with a known ID can be retrieved successfully.

5. **`patchCommentWithNewContent_ReturnsNewContentInResponseBody()`**:
   - Tests if updating a comment's content returns the updated content.

### Helper Methods

- **`getJsonResponseWithStatus()`**:
  - Returns a response specification expecting a specific status code and JSON content type.
- **`getReponseStatus()`**:

  - Returns a response specification expecting a specific status code.

- **`getRequestSpecification()`**:
  - Builds and returns a request specification with base URI, base path, headers, and path parameters set.

### Notes:

- The tests interact with GitHub's REST API (`https://api.github.com`).
- The tests use a Personal Access Token (PAT) for authentication (`Authorization` header).
- The tests are focused on CRUD operations for GitHub repository comments.
