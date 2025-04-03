import { useEffect, useState } from "react";
import { BarChart, CartesianGrid, XAxis, YAxis, Tooltip, Legend, Bar, ResponsiveContainer, LabelList } from "recharts";

function SpendingDiagram({ transactions }) {
    const [diagramData, setDiagramData] = useState([]);

    useEffect(() => {
        const categories = [];

        transactions.forEach(transaction => {
            const category = transaction.category.description;
            categories.includes(category) || categories.push(category);
        });

        const diagramData = [];

        categories.forEach(category => {
            diagramData.push({
                name: [category],
                spending: transactions
                    .filter(transaction => transaction.category.description === category)
                    .reduce((acc, transaction) => acc + transaction.amount, 0)
            })
        });

        setDiagramData(diagramData);
    }, [transactions]);

    return (
        diagramData.length < 3 ? (
            <></>
        ) : (
            <ResponsiveContainer width="100%" height="100%" >
                <BarChart data={diagramData}>
                    <CartesianGrid strokeDasharray="3 3" />
                    <XAxis dataKey="name"  fontSize={25}/>
                    <Tooltip />
                    <Bar dataKey="spending" fill=" #ff1616">
                        <LabelList dataKey="spending" position="insideBottom" fill="#ffffff" fontSize={30}/>
                    </Bar>
                </BarChart>
            </ResponsiveContainer>
        )
    );
}

export default SpendingDiagram;
