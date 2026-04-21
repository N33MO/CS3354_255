# Module 6

This folder contains simple Java examples for learning JUnit tests:

- `AssertMethods` - examples of common JUnit assertion methods
- `MyClass` - a small class with basic unit tests

## How to Open the Examples

Open `Module6` directly as the project root in VS Code.

For proper package resolution, do not open the entire `CS3354_255_DEMO` directory as the project root when working with these examples. The package declarations in this folder are defined relative to `Module6`.

For example:

- `AssertMethods/HelloWorldTest.java` uses `package AssertMethods;`
- `MyClass/MyClassTest.java` uses `package MyClass;`

If you open the parent `CS3354_255_DEMO` directory instead, VS Code may treat the source root differently and the JUnit test icons may not appear correctly.

## JUnit Setup

This folder uses the standalone JUnit jar in:

```text
lib/junit-platform-console-standalone-6.0.3.jar
```

No Maven or Gradle setup is required for these examples.

To make VS Code recognize the JUnit jar and show test run icons, add these settings to your VS Code User Settings JSON:

```json
{
  "java.project.sourcePaths": [
    "."
  ],
  "java.project.outputPath": "bin",
  "java.project.referencedLibraries": [
    "lib/**/*.jar"
  ],
  "editor.codeLens": true,
  "editor.glyphMargin": true,
  "testing.gutterEnabled": true
}
```

Open User Settings JSON from the Command Palette:

```text
Preferences: Open User Settings (JSON)
```

After opening `Module6`, if VS Code does not show the test run icons, run:

```text
Java: Clean Java Language Server Workspace
```

Then reload VS Code when prompted.

## How to Run Tests

Open a test file, such as:

- `AssertMethods/HelloWorldTest.java`
- `MyClass/MyClassTest.java`

Then use the `Run Test` icons shown by VS Code next to the test class or individual test methods.
