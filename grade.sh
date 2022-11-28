# Create your grading script here

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

cp TestListExamples.java student-submission/
cp -r lib student-submission/

cd student-submission

if [[ -e ListExamples.java ]]
then 
    echo "file found"
    exit 0
else 
    echo "file not found"
    exit 1
fi 

javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java &> compile.txt 

if [ $? -eq 0 ]
then 
    echo "passed"
    java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples &> result.txt

    if grep "OK" result.txt
    then 
        echo "Test passed"
    fi

    if grep "FAILURES" result.txt
    then 
        echo "Failed"
    fi

else
    cat compile.txt
    echo "Compile error"
    echo "Failed"
    exit 1
fi
