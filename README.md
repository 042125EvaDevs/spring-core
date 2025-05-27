# SpringCore Resources

## Getting started

**Create a directory for this cohort**

```bash
# Navigate to your home folder
cd ~/

# create a new folder for Eva related files/folders
mkdir eva-cohort
cd eva-cohort
```

**Clone this repository on to your filesystem**

```bash
git clone https://github.com/042125EvaDevs/spring-core.git
```


**Create a new branch with your name as the branch name**
```bash
git checkout -b <your-name>
```
> This is where you will implement your code changes

## Development Tools
- [Git - _version control_](https://git-scm.com/downloads)
- [VS Code - _code editor_](https://code.visualstudio.com/download)


## Download updates from Github

Checkout the main branch
```bash
# switch shared branch between everyone
git checkout main

# download updates from online Github repository
git fetch

# Pull changes into local main branch
git pull
```

Merge changes into your branch
```bash
git checkout <your-branch>
git merge main
```

## Pushing changes to github

Stages changes to be committed to git

```bash
git add .
```

Commit changes to git with a message about the changes.
```bash
# Leave a message about changes made
git commit -m "added nav button"
```

Push to github
```bash
# if you have not created the branch on github yet
git push -u origin <your-branch-name>

# otherwise this will push to your branch on github
git push
```
