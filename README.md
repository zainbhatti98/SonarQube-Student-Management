# SonarQube Student Management

A small Java Student Management System for testing static code analysis.

## Repository name
`SonarQube-Student-Management`

## Folders
- `before/StudentManagement.java`: intentionally includes examples of poor code-quality practices.
- `after/StudentManagement.java`: improved version with refactoring and input validation.

## Important: scan one version at a time
Do not scan both folders together for the before/after comparison. The classes have the same name.

### Option A: SonarQube Cloud / CI
Configure your analysis so `sonar.sources` points to `before` for the first analysis. Commit the results/screenshots, then point it to `after` for the second analysis. Depending on your setup, use separate branches or separate project keys to preserve both results.

### Option B: SonarScanner CLI
Run the scanner from the repository root and configure one source folder at a time.

Before:
`sonar.sources=before`

After:
`sonar.sources=after`

Use the project key, token, and server URL appropriate for your SonarQube setup. Never commit a token to GitHub.

## Compile and run locally
Use a JDK that supports the switch-arrow syntax in the improved version (Java 14+, preferably Java 17 or newer).

Before:
```bash
javac before/StudentManagement.java
java -cp before StudentManagement
```

After:
```bash
javac after/StudentManagement.java
java -cp after StudentManagement
```

## Notes
- SonarQube results depend on the server version, analyzer, enabled rules, and scan configuration.
- It is not guaranteed to report every intentional issue in `before`; record the actual findings.
- A zero count for bugs, vulnerabilities, or security hotspots is a valid result. Do not invent findings.
- Capture screenshots of the first analysis before changing/fixing code, then capture the second analysis after.
