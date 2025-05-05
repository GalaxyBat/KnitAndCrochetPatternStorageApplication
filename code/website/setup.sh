if [[ -n "$1" ]]; then
    echo "Running $1"
    
    if [[ "$1" == "launch" ]]; then
        npm install
        node app
    elif [[ "$1" == "test" ]]; then
        echo "we should do something here"
    fi
else
    echo "Must provide at least one argument."
fi