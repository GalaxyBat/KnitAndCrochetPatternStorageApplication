if [[ -v 1 ]]; then
    echo "Running $1"
    echo $1
    if [[ $1 == "launch" ]]; then
        np install
        node app
    else [[ $1 == "test" ]]; then
        echo "we should do something here"
    fi
fi