import { useEffect, useState } from "react";
import {fetchData} from "../utils";

function AddExpenseForm({userId, setExpense}) {
    const [categories, setCategories] = useState([]);

    const [isFilled, setIsFilled] = useState(false);

    const [category, setCategory] = useState(null);
    const [name, setName] = useState(null);
    const [amount, setAmount] = useState(null);

    useEffect(() => {
        setIsFilled(category && name && amount);
    }, [category, name, amount]);

    useEffect(() => {
        fetchData("transactions/categories/all").then(response => setCategories(response));
    }, []);

    function handleSubmit(e) {
        e.preventDefault();

        const expenseObject = {
            memberId: userId,
            categoryId: category,
            name: name,
            amount: amount
        };

        let transactionId;
        fetchData("transactions/add", "POST", expenseObject)
        .then(response => transactionId = response)
        .then(() => {
            fetchData("transactions/1/all").then(response => {
                const sumWithInitial = response.reduce((accumulator, currentValue) => accumulator + currentValue.amount, 0);
                setExpense(sumWithInitial);
            })
        })
      
        document.getElementById("my_modal_4").close();
    }

    return (
        <form onSubmit={handleSubmit}>
            <select defaultValue="Pick a category" className="select" onChange={(event) => setCategory(event.target.value)}>
                <option disabled={true}>Pick a category</option>
                {categories.map(category => (<option key={category.id} value={category.id}>{category.categoryType}</option>))}
            </select>
            <fieldset className="fieldset flex">
                <legend className="fieldset-legend">Name</legend>
                <input type="text" className="input" placeholder="Expense name" onChange={(event) => setName(event.target.value)}/>
            </fieldset>
            <fieldset className="fieldset flex">
                <legend className="fieldset-legend">Amount</legend>
                <input type="number" className="input" placeholder="Expense amount" onChange={(event) => setAmount(event.target.value)}/>
            </fieldset>
            <button type="submit" className="btn btn-primary" disabled={!isFilled}>Add expense</button>
        </form>
    )
}

export default AddExpenseForm;
