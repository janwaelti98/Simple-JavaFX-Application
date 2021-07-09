# OOP2 Programming Project 2ICeng/2ICbb FS21 

## Edited By
Jan Wälti

## Implemented features

### All basic features
- Loading of the data
- Saving of Changes
- Visualize all HeritageSites in a table
- Editor-View
- Layout with SplitPane 
- Reasonable Resizing-Management
- Simple styling via CSS  
- Creation of a new Heritage Site
- Deletion of a Heritage Site

### Advanced features
- Application-Structure (Consequent use of presentationModel - concept / separate UI classes)
- Overhaul of the UI (CSS styling of whole application)
- Enabling / Disabling of editors view
- Enabling / Disabling of delete & save button (if no heritage site is selected)
- Whole application in German and English translatable
- Input validation of text fields

## Grading
4.0 (Basic Features) + 1.0 (Application structure) + 0.5 (Translation / Input Validation) + 0.5 (Presentation) = 6.0

## Handing in
- Sunday, 01.06.21, 18:00
- Handing-in happens through a "Push" to the Master-Branch of your GitHub repository.


## Exercise: HeritageSites FX
Implement your own application on the basis of JavaFX according to the description on the AD.

That description is the most important one, here are the most important points as reminder:

- For the implementation use the structure of the "Application-Template"
- Usage of SceneBuilder and FXML are prohibited
- For a 4.0 you need to implement at least the following features
    - Loading of the data
    - Saving of Changes
    - Visualize all HeritageSites in a table/list
    - Editor-View
        - Editor-View always works on the selected item from the table
        - Changes lead to an *immediate* update of the table and the header
        - Changes of *hasVisited* leads to an immediate update of the Footer elements
            - Number of Countries Visited
            - Number of Places visited
            - List of Countries visited (using abbreviations)
        - Footer
            - Number of Countries Visited
            - Number of Places visited
            - List of Countries visited  
            - simple styling with CSS
    - Layout with SplitPane
    - reasonable Resizing-Management
    - Creation of a new Heritage Site
    - Deletion of a Heritage Site
    - Application-Structure
        - two Layers for Presentation-Model and View
    

## Notes
- The grading criteria are available on the AD in a PDF file
    - The defined criteria in there are authoritative
    - non compiling code will be graded with 1.0
    - projects that are not worked on independently lead to a significant mark deduction
- In the project you find the data file
    - `resources/data/heritage_sites.csv` contain the Heritage Sites to display
- It is expressly permitted and desired that you get help if necessary.
    - The "Programmierzentrum" is open and questions are gladly answered either through the integrated Issue Tracker or by mail.
