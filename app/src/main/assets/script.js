window.addEventListener("load", function () {
                               	var chart = new CanvasJS.Chart("chartContainer", {
                               		theme: "theme2",//theme1
                               		title:{
                               			text: "Basic Column Chart - CanvasJS"
                               		},
                               		animationEnabled: true,   // change to true
                               		data: [
                               		{
                               			// Change type to "bar", "area", "spline", "pie",etc.
                               			type: "column",
                               			dataPoints: [
                               				{ label: "lunes",  y: InterfazAndroid.getDia(1)  },
                               				{ label: "martes", y: InterfazAndroid.getDia(2)  },
                               				{ label: "miercoles", y: InterfazAndroid.getDia(3)  },
                               				{ label: "jueves",  y: InterfazAndroid.getDia(4)  },
                               				{ label: "viernes",  y: InterfazAndroid.getDia(5)  },
                               				{ label: "sabado",  y: InterfazAndroid.getDia(6)  },
                               				{ label: "domingo",  y: InterfazAndroid.getDia(0)  }
                               			]
                               		}
                               		]
                               	});
                               	chart.render();
                               	});
