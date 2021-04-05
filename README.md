# My Personal Project

## A workout manager app

One of the pillars of my life has been my personal fitness journey and staying active with vigorous workout routines 
has become an integral part of my day-to-day life. With a variety of routines and exercises, I often find myself unable
to keep an accurate record of each workout I do and better monitor my progress on a finer scale. I often notice 
individuals in the gym carrying physical journals to log their workouts and keep track of their progress. Creating an 
application that can be integrated into our personal devices (phones, smart watches) could eliminate the need to carry
around extra material like journals and allow for a more efficient way to track progress and quantify the effects that
these workouts are having on an individual's physical performance.

The main purpose of this application is to act as a **personal fitness log** that users can use to keep track of their 
physical activity and monitor their progress. The application will allow for users to input their workouts by logging 
exercises done under **three categories**. The three categories are as follows:

- Strength-training
- Endurance-training
- Flexibility-training

Users will be able to input calories burnt per workout and add that information to their log. On a week-to-week basis,
users will be able to compare their logs and monitor for progress to note if they have improved or regressed.

This application is targeted to a wide variety of individuals who want to keep track of their exercise routines or 
fitness journeys. The app is meant to work as a personal fitness diary, so individuals from all walks of life who care 
enough about their fitness journeys will be able to use the app with relative ease.

## User stories

As a user, I want to be able to: 

- add my workouts to a log
- categorize the different exercises I do
- track of the intensity of my workouts via calories burnt
- view a summary of all of my logged exercises and intensity of each
- save my workouts when I'm done using the app
- load my workout history and compare my workouts to each other

## Phase 4: Task 2

I have chosen to implement a type hierarchy in my code. There are two abstract classes in my code. The first is seen in
the exercises package in the model package where an abstract exercise class is extended by the FlexibilityExercise, 
EnduranceExercise, and StrengthExercise classes. These classes inherit all the fields of the Exercise abstract class and
each of their constructors behaves differently. Another example of a type hierarchy in my code is in my panels package 
within the ui package. The AddScreen abstract class is extended by the AddEnduranceScreen, AddFlexibilityScreen, and 
AddStrengthScreen classes. The subclasses all Override the saveFields method from the AddScreen class and implement this
method differently. 


## Phase 4: Task 3

In my class diagram, I can see that my design has made good use of abstract classes to reduce redundancies in code and
to reduce semantic coupling between classes. The classes in my application have a lot of similar code as many classes
emulate each other and do similar things with minor differences, so the use of abstract classes to abstract these 
similarities made it easier to edit code without errors. One thing I noticed when creating this UML diagram was that 
there was certainly room for improvement in cohesion of my GUI classes. In particular, the AddEnduranceScreen, 
AddFlexibilityScreen, and AddStrengthScreen could have been split into more classes to further separate the JPanel 
components into their own unique classes and allow for more seamless edits should I want to add or replace features. 

In addition, there are still some methods I feel could be abstracted and moved into existing abstract classes as there 
are a few points in my code where redundancies exist between similar classes and abstracting some of these redundancies
will surely improve coupling issues. Overall, I am happy with many of the design choices I made in my application. 
