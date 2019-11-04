*** For Windows ***

To list all gradle tasks:
gradlew.bat tasks

To build:
gradlew.bat build

To run from command line:
gradlew.bat run


1. Get remot repo to active repo locally:
git clone https://github.com/MatterCollapse/Fake-Plants

Cloning into 'Fake-Plants'...
remote: Enumerating objects: 29, done.
remote: Counting objects: 100% (29/29), done.
remote: Compressing objects: 100% (19/19), done.
remote: Total 29 (delta 4), reused 26 (delta 3), pack-reused 0
Unpacking objects: 100% (29/29), done.


2. To get status of LOCAL repo (from the folder where the LOCAL repo is located):
git status

If NO changes:

On branch master
Your branch is up to date with 'origin/master'.

If there are some changes

On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

	modified:   README.md

This means we have LOCAL changes and no REMOTE changes