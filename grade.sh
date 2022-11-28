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
else 
    echo "file ListExample.java not found"
    exit 1
fi 

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java &> compile.txt 

if [ $? -eq 0 ]
then 
    echo "Compile successfully"
    java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples &> result.txt

    if grep "OK" result.txt
    then 
        echo "You get 100 out of 100 points!"
    fi

    if grep -i "FAILURES" result.txt
        if grep -i "FAILURES: 1" result.txt
        then 
            echo "You get 50 out of 100 point."
        else
            echo "You get 0 out of 100 points."
    fi

else
    cat compile.txt
    echo "Compile error"
    echo "Failed"
    exit 1
fi
