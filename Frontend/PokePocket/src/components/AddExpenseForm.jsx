import { useEffect, useState } from "react";
import {fetchData} from "../utils";

function AddExpenseForm({userId, setExpense}) {
    const [categories, setCategories] = useState([]);

    const [category, setCategory] = useState(0);
    const [name, setName] = useState("");
    const [amount, setAmount] = useState(0);

    // useEffect(() => {
    //     fetchData("/transactions/categories").then(response => setCategories(response));
    // }, []);

    function handleSubmit(e) {
        e.preventDefault();

        const expenseObject = {
            memberId: userId,
            categoryId: category,
            name: name,
            amount: amount
        };

        let transactionId;
        fetchData("transactions/add", "POST", expenseObject).then(response => transactionId = response);
        // fetchData("transactions/")
        document.getElementById("my_modal_4").close();
    }

    return (
        <form onSubmit={handleSubmit}>
            <select defaultValue="Pick a category" className="select" onChange={(event) => setCategory(event.target.value)}>
                <option disabled={true}>Pick a category</option>
                {categories.map(category => (<option id={category.id}>{category.name}</option>))}
            </select>
            <fieldset className="fieldset flex">
                <legend className="fieldset-legend">Name</legend>
                <input type="text" className="input" placeholder="Expense name" onChange={(event) => setName(event.target.value)}/>
            </fieldset>
            <fieldset className="fieldset flex">
                <legend className="fieldset-legend">Amount</legend>
                <input type="number" className="input" placeholder="Expense name" onChange={(event) => setAmount(event.target.value)}/>
            </fieldset>
            <button type="submit" className="btn btn-primary">Add expense</button>
        </form>
    )
}

export default AddExpenseForm;
