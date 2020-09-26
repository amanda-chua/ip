# User Guide

Duke is an offline application for managing various tasks. It is optimised for those 
who prefer to work with a Command Line Interface (CLI).

## Features 
### 1. Welcome message
This feature prints out a welcome message once the program starts.
    
Expected output:
    
     Hello! I'm Duke
            _____________       
           /             \     
       \  /    >      <   \  /
        \|         *       |/ 
          \               /   
           \_____________/    
              ^^     ^^        
     
     What can I do for you?


### 2. Add a task
Duke can manage three types of tasks:
* *Todos*: tasks without any date/time attached to it
* *Events*: tasks that start at a specific time
* *Deadlines*: tasks that need to be done before a specific date

#### Todo tasks
Format: 'todo [description]'

Example:
    `todo read book`
    
Expected output:

     Got it. I've added this task:
      [T][N] read book
     ---------------------------------------------------------------------
     Now you have 1 tasks in the list!
     ---------------------------------------------------------------------

#### Event tasks
Format: 'event [description] /at [timing]'

Example:
    `event eat cake /at 3pm`
    
Expected output:

     Got it. I've added this task:
      [E][N] eat cake  (at: 3pm)
     ---------------------------------------------------------------------
     Now you have 2 tasks in the list!
     ---------------------------------------------------------------------

#### Deadline tasks
Format: 'deadline [description] /by [date(YYYY-MM-DD)]'

Example:
    `deadline return book /by 2020-09-30`
    
Expected output:
    
     Got it. I've added this task:
      [D][N] return book  (by: Sep 30 2020)
     ---------------------------------------------------------------------
     Now you have 3 tasks in the list!
     ---------------------------------------------------------------------

### 3. Mark task as done
This feature marks the selected task as done:

Format: 'done [index of task]'    

Example:
    `done 1`
    
Expected output:
    
     Nice! I've marked this task as done:
      [T][Y] read book
     ---------------------------------------------------------------------

        
### 4. List tasks
This feature lists all the tasks in Duke:

Format: 'list'    

Example:
    `list`
    
Expected output:
    
     Here are the tasks in your list:
     1. [T][Y] read book
     2. [E][N] eat cake  (at: 3pm)
     3. [D][N] return book  (by: Sep 30 2020)
     ---------------------------------------------------------------------
        
### 5. Delete task
This feature deletes the selected task from list:

Format: 'delete [index of task]'    

Example:
    `delete 2`
    
Expected output:
    
     Noted. I've removed this task: 
        [E][N] eat cake  (at: 3pm)
     Now you have 2 tasks in the list.
     ---------------------------------------------------------------------
     
### 6. Find tasks consisting a keyword
This feature finds task consisting of the keyword from list:
 
Format: 'find [keyword]'    
 
Example:
    `find read`
     
Expected output:
 
     Here are the matching tasks in your list:
      1. [T][Y] read book
     ---------------------------------------------------------------------
      
    
### 7. Exit Duke
This feature exits the program:
 
Format: 'bye'    
 
Example:
    `bye`
     
Expected output:

            _____________       
           /             \     
          /    x      x   \   
       /\|         ~       |/\ 
          \               /   
        ~  \_____________/    
       ~      ^^     ^^        
     
     Bye. Hope to see you again soon!
     ---------------------------------------------------------------------