function Challenge({challenge}){
    return (
        <a href="#" class="list-group-item list-group-item-action" aria-current>
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">{challenge.month}</h5>

            </div>
            <p class="mb-1">{challenge.description}</p>
        </a>
    );
}

export default Challenge;